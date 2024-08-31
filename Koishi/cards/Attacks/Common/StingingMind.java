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
/*    */ public class StingingMind extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(StingingMind.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("StingingMind.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 8;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int DEBUFF = 2;
/*    */   
/*    */   public StingingMind() {
/* 35 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.baseDamage = 8;
/* 37 */     this.magicNumber = this.baseMagicNumber = 2;
/* 38 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("specialAttackC");
/* 44 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
/* 46 */     for (int i = 0; i < 2; i++) {
/* 47 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 53 */     if (!this.upgraded) {
/* 54 */       upgradeName();
/* 55 */       upgradeDamage(3);
/* 56 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/StingingMind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */