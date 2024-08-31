/*    */ package Koishi.cards.Attacks.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class RacingHeart extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(RacingHeart.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("RacingHeart.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 9;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 1;
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public RacingHeart() {
/* 36 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 37 */     this.baseDamage = 9;
/* 38 */     this.magicNumber = this.baseMagicNumber = 2;
/* 39 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 44 */     KoishiMod.runAnimation("occultAttack");
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
/*    */     
/* 47 */     if (m.hasPower(TerrorPower.POWER_ID)) {
/* 48 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeDamage(1);
/* 57 */       upgradeMagicNumber(1);
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/RacingHeart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */