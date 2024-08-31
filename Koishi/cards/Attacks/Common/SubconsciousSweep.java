/*    */ package Koishi.cards.Attacks.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class SubconsciousSweep
/*    */   extends AbstractIdCard {
/* 16 */   public static final String ID = KoishiMod.makeID(SubconsciousSweep.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("SubconsciousSweep.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 10;
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   public SubconsciousSweep() {
/* 30 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.baseDamage = 10;
/* 32 */     this.isMultiDamage = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     KoishiMod.runAnimation("magicAttackB");
/* 38 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_HEAVY));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 44 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 50 */     if (!this.upgraded) {
/* 51 */       upgradeName();
/* 52 */       upgradeDamage(3);
/* 53 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/SubconsciousSweep.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */