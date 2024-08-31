/*    */ package Koishi.cards.Attacks.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import basemod.helpers.BaseModCardTags;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class BasicStrike
/*    */   extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(BasicStrike.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("BasicStrike.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.BASIC;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   private static final int DAMAGE = 6;
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   public BasicStrike() {
/* 31 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.baseDamage = 6;
/*    */     
/* 34 */     this.tags.add(BaseModCardTags.BASIC_STRIKE);
/* 35 */     this.tags.add(AbstractCard.CardTags.STRIKE);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("magicAttackB");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       upgradeDamage(3);
/* 50 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/BasicStrike.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */